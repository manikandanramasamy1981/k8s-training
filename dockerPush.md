# Build a image , tag it , push to docker repository 
docker build -t node-app:1.0.0 .
docker images
docker tag node-app:1.0.0 manikandanramasamy/node-app:1.0.0
docker push manikandanramasamy/node-app:1.0.0
docker login 
docker push manikandanramasamy/node-app:1.0.0
docker inspect node-app
docker inspect 37188db9afcc  #imageid 
