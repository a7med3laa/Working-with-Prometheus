# Working-with-Prometheus


Java project to work with Prometheus a monitoring platform. The code communicates through HTTP requests to get the performance metrics of a server that the IoT platform is deployed on it. Prometheus has two main components Prometheus server and node exporter. Prometheus server is used as a central point to monitor and collect metrics from different devices and node exporter is deployed in a server that we want to test its performance and send collected metrics to Prometheus server. In my java code, I send HTTP requests to the Prometheus server to get the reading that is collected. This Java code is used with JMeter test scripts to evaluate IoT platform performance. 

Results of this evaluation performance test are published in a scientific paper called "Performance Evaluation of Open Source IoT Platforms"

Ismail, Ahmed A., Haitham S. Hamza, and Amira M. Kotb. "Performance evaluation of open source IoT platforms." 2018 IEEE Global Conference on Internet of Things (GCIoT). IEEE, 2018.

https://prometheus.io/docs/introduction/overview/

https://ieeexplore.ieee.org/document/8620130
