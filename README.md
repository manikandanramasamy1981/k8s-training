# k8s-training
docker build -t javaapp:1.0.0 .
#  -t for tagging version 
docker run -d --name javaapp1 -p 8080:8080 
# -d to run the logs in background 
# --name  to provide name to conatainer 
# -p  to expose port (8080) on host from containerport(8080)
