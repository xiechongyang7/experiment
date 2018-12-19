package akka;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 15:55
 * @Author xie
 */
public class ProduceMsgActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class,t->{
            //收到消息
            System.out.println(self()+"  receive msg  from "+sender()+": "+ t);

            //响应消息请求
            Msg msg = new Msg("haha");
            System.out.println(self()+"  produce msg : "+msg.getContent());

            //根据路径查找下一个处理者
            ActorSelection nextDisposeRefs = getContext().actorSelection("/user/DisposeMsgActor");

            //将消息发给下一个处理者DisposeMsgActor
            nextDisposeRefs.tell(msg,self());
        }).matchAny(t->{
            System.out.println("no disposer");
        }).build();
    }
}
