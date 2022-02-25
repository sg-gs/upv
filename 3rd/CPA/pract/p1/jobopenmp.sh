#!/bin/bash
# Using more than 1 node is useless as OpenMP works with shared memory
# and clusters do not share their memory with their relatives. 
#SBATCH --nodes=1
#SBATCH --time=5:00
#SBATCH --partition=cpa
OMP_NUM_THREADS=2 ./pimagenes