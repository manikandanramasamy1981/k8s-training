docker build -t cmdimage:0.0.1 . 
# To build images 
docker run -d --name cmdimage2 cmdimage:0.0.1 echo Hello India
# Pass argument to override 
docker logs cmdimage2
#To see the log
