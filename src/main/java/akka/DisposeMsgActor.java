package akka;

import akka.actor.AbstractActor;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 15:56
 * @Author xie
 */
public class DisposeMsgActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Msg.class,t->{
            //收到消息
            System.out.println(self()+"  receive msg  from "+sender()+": "+ t.getContent());
            System.out.println(self()+" dispose msg : "+t.getContent());
        }).matchAny(t->{
            System.out.println("no disposer");
        }).build();
    }
}
