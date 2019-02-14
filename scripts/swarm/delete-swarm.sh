#!/bin/sh

source create-swarm.sh

# clean docker client env
echo "#### cleaning docker env..."
eval $(docker-machine env -u)

# remove nodes
echo "#### removing nodes..."
for (( i = start_node; i <= ${end_node}; i++ )); do
    docker-machine rm node${i} --force
done
