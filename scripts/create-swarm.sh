#!/usr/bin/env bash

echo "#### creating swarm..."

# creating nodes

echo "#### creating nodes..."
nodes=(1..6)
node_count=${#nodes[@]}
for var in ${node_count} ; do
    echo ${var}
    docker-machine create -d virtualbox node${var}
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
manager_nodes=(2)
for var in ${manager_nodes[@]} ; do
    eval $(docker-machine env node${var})
    docker swarm join --token ${manager_token} ${leader_addr}
done

# connecting worker nodes
echo "#### worker nodes joining..."
worker_nodes={${manager_nodes[@]}+1..${node_count}}
for var in ${worker_nodes} ; do
    eval $(docker-machine env node${var})
    docker swarm join --token ${worker_token} ${leader_addr}
done

# clean docker client env
echo "#### cleaning docker env..."
eval (docke-machine env -u)

# export var
export node_count