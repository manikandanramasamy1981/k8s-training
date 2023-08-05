# Build a image , tag it , push to docker repository 
docker build -t node-app:1.0.0 .
# list docker images
docker images
# Tag the image
docker tag node-app:1.0.0 manikandanramasamy/node-app:1.0.0
# push the image to your repo
docker push manikandanramasamy/node-app:1.0.0
# login to repo , you will be asked username and password - Enter those im command prompts 
docker login 
# push the image to repository
docker push manikandanramasamy/node-app:1.0.0
# inspect the image
docker inspect node-app
#
docker inspect 37188db9afcc  #imageid 
