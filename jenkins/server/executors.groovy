import jenkins.model.*
def env = System.getenv()
Jenkins.instance.setNumExecutors(env.MASTER_EXECUTORS)