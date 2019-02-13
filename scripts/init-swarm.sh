#!/bin/sh

# start nodes
echo "#### starting nodes..."
for (( i = ${start_node}; i <= ${end_node}; i++ )); do
    docker-machine start node${i}
done

# clean docker client env
echo "#### cleaning docker env..."
eval (docker-machine env -u)