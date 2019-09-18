# ci-infrastructure

## TeamCity
1. Run
`docker-compose -f docker-compose.teamcity.yml up -d`  
- Setup  
- Stop  
`docker-compose -f docker-compose.teamcity.yml stop`  
- Run again to connect agent

## Jenkins
1. Run
`docker-compose -f docker-compose.jenkins.yml up -d`  
2. Stop  
`docker-compose -f docker-compose.jenkins.yml stop`  

#References
1. https://code-maze.com/docker-series/