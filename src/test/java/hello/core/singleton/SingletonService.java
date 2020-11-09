package hello.core.singleton;

public class SingletonService {
    //static 이므로 class level 이므로 단하나!
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //private 으로 new 키워드를 이용한 객체생성 방
    private SingletonService(){
    }

    public void logic(){
        System.out.println("Singleton 객체 호출");
    }
}
