#!/usr/bin/env bash

# clean docker client env
echo "#### cleaning docker env..."
eval (docke-machine env -u)

# remove nodes
echo "#### removing nodes..."
for var in ${nodes_count} ; do
    eval $(docker-machine rm node${var} --force)
done

