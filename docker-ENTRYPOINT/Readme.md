docker build -t entryimage:1.0.0 .
#build image
docker run -d --name entryimage2 entryimage:1.0.0 echo hello india
# To append comments in the output 
