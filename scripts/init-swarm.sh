#!/usr/bin/env bash

# start nodes
echo "#### starting nodes..."
for var in ${nodes_count} ; do
    docker-machine start node${var}
done

# clean docker client env
echo "#### cleaning docker env..."
eval (docke-machine env -u)