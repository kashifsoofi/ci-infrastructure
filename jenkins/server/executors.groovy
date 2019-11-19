import jenkins.model.*
Jenkins.instance.setNumExecutors(env.MASTER_EXECUTORS)