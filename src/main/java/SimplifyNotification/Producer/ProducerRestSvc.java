package SimplifyNotification.Producer;

import SimplifyNotification.Utils.NotificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerRestSvc {

    @Autowired
    private KafkaTemplate<String, NotificationTemplate> notificationTemplate;

    public String restresult = "";
    @PostMapping(value = "sendMessage", consumes = "application/json", produces = "application/json")
    public String sendMessages(@RequestBody NotificationTemplate notify){
        ListenableFuture<SendResult<String, NotificationTemplate>> future = notificationTemplate.send(notify.topicName,notify);
        future.addCallback(new ListenableFutureCallback<SendResult<String, NotificationTemplate>>() {
            @Override
            public void onFailure(Throwable ex) {
                restresult = ex.toString();
            }

            @Override
            public void onSuccess(SendResult<String, NotificationTemplate> result) {
                restresult = result.toString();
            }
        });
        return restresult;
    }
}
