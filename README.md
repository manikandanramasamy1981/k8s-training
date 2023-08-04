# k8s-training
docker build -t javaapp:1.0.0 .
#  -t for tagging version 
docker run -d --name javaapp1 -p 8080:8080 
# -d to run the logs in background 
# --name  to provide name to conatainer 
# -p  to expose port (8080) on host from containerport(8080)
docker logs javaapp1
# To see logs of the container 
history 
# To provide history of commands ran in the console 
docker ps 
# To list all the running containers 
docker ps -a 
# To list all the containers including stopped ones 
docker exec -it javaapp1 bash
# To login to container 
docker stats 
# to show the resource utilization of containers 
docker images 
# To show all the images in the repository
docker cp <src>  <Destination>
# To copy file from host to container - can copy from host to container and container to host 
curl localhost:8080 
# To check the service running in 8080



