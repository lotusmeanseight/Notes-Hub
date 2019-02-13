#!/bin/sh

echo "#### creating swarm..."

# creating nodes

start_node=1
end_node=6

echo "#### creating nodes..."
for (( i = ${start_node}; i <= ${end_node}; i++)); do
    docker-machine create -d virtualbox node${i}
done

# leader node address
leader_addr=$(docker-machine ip node1)

# init docker Swarm
echo "#### init docker Swarm..."
eval $(docker-machine env node1)
docker swarm init --advertise-addr ${leader_addr}

# set swarm tokens
manager_token=$(docker swarm join-token manager -q)
worker_token=$(docker swarm join-token worker -q)

# connecting manager nodes
echo "#### manager nodes joining..."
manager_node_start=${start_node}+1
manager_node_end=2
for (( i = ${manager_node_start}; i <= ${manager_node_end}; i++ )); do
    eval $(docker-machine env node${i})
    docker swarm join --token ${manager_token} ${leader_addr}
done

# connecting worker nodes
echo "#### worker nodes joining..."
worker_nodes={${manager_node_end}+1..${node_count}}
for (( i = manager_node_end + 1; i <= ${end_node}; i++ )); do
    eval $(docker-machine env node${i})
    docker swarm join --token ${worker_token} ${leader_addr}
done

# clean docker client env
echo "#### cleaning docker env..."
eval (docker-machine env -u)

# export var
export start_node
export end_node