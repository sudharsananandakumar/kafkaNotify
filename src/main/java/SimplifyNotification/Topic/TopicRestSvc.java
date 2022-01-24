package SimplifyNotification.Topic;

import SimplifyNotification.Utils.Topic;
import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
public class TopicRestSvc {
    @Autowired
    private Admin admin;

    @PostMapping(value = "createTopic", consumes = "application/json", produces = "application/json")
    public String createTopic(@RequestBody Topic topic) throws Exception{
        NewTopic newTopic = new NewTopic(topic.topicName,topic.num_partitions,(short) topic.num_partitions);
        CreateTopicsResult result = admin.createTopics(Collections.singleton(newTopic));
        KafkaFuture<Void> future = result.values().get(topic.topicName);
        future.get();
        return future.toString();
    }

}
