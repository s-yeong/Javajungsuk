package org.chapter14.ex;
/**
 * null이 될 수 있는 값 대신에 Optional 객체에 집어넣어서 쓰자!
 * null을 최소화 하는 습관을 가지자
 */
/*
    Optional<T>
    "T타입의 객체"를 감싸는 "래퍼 클래스"이다.      - 래퍼 클래스는 T타입의 참조변수를 가지고 있다
    => Optional 타입의 객체이는 "모든 타입의 객체"를 담을 수 있다!
    - 필요한 이유? 1. null을 직접다루는 것은 위험 (간접적으로 null 다루기) 2. null 체크

    최종 연산의 결과를 그냥 반환하는게 아니라 Optional 객체에 담아서 반환을 하면,
    반환된 결과가 null인지 매번 if문으로 체크하는 대신
    => Optional에 정의된 메서드를 통해서 간단히 처리할 수 있다.

    널 체크를 위한 if문 없이도 NullPointerExcpetion이 발생하지 않는
    보다 간결하고 안전한 코드를 작성하는 것이 가능하다.

    public final class Optional<T> {
        private final T value; // T 타입의 참조 변수
    }

    null을 직접 다루지 않는 경우
    String str = ""; 빈 문자열로 함(new char[0]; 길이가 0인 char 배열)
    int[] arr = new int[0];
    => null인지 아닌지 체크할 필요 없음
 */

/*
    Optional<T> 객체 생성
    of() - 매개변수의 값이 null이면 NullPoinerExcpeion이 발생함
    ofNullable() - 참조변수의 값이 null일 가능성이 있는 경우

    Optional<T> 타입의 참조변수를 기본값으로 초기화할 때는 empty()사용
    null로 초기화하는 것이 가능하지만, empty()로 초기화 하는 것이 바람직함
    
    Optional<T> 객체의 값 가져오기
    get() 사용    (잘안씀)
        값이 null일 때는 NoSuchElementException 발생
        => 이를 대비해서 orElse()로 대체할 값을 지정할 수 있다!
    orElse() 변형 
        orElseGet() -> null 대체값을 람다식으로 반환
        orElseThrow() -> null일 때 발생할 예외 지정 가능
   isPresent()
        Optional 객체의 값이 null이면 false, 아니면 true 반환
   ifPresent()
        null이 아닐때만 주어진 람다식 실행, null이면 X
 */

/*
    OptionalInt, OptionalLong, OptionalDouble
    IntStream과 같은 기본형 값을 감싸 래퍼클래스 (Optional<T> 써도 되지만 성능때문에 씀)

    Optional<T> - T get()
    OptionalInt - int getAsInt(), OptionalLong long getAsLong() ...

    반환 타입이 Optional<T>가 아니라는 것을 제외하고는 Stream에 정의된 것과 유사하지만

    OptionalInt opt = OptionalInt.of(0);    // 0 저장
    OptionalInt opt2 = OptionalInt.empty(); // 0 저장
    기본형 int의 기본값은 0이므로 아무런 값도 갖지 않는 opt2에 저장된 값은 0이다!
    ?? 어떻게 구별 ?? => isPresent를 통해 구별

 */
import java.util.Optional;
import java.util.OptionalInt;

public class Ex14_8_Optional {
    public static void main(String[] args) {

        int[] arr = new int[0]; // null로 두면 안됨!
        System.out.println("arr.length = " + arr.length);


        String str = "abc";
        Optional<String> optVal = Optional.of(str);

//        Optional<Object> optVal2 = Optional.of(null);   // NullPointerException 발생
        Optional<Object> optVal2 = Optional.ofNullable(null);

        // Optional<T> 타입의 참조변수를 기본값으로 초기화할 때는 empty()사용
        // null로 초기화하는 것이 가능하지만, empty()로 초기화 하는 것이 바람직함
        Optional<String> optVal3 = Optional.empty(); // 빈 객체로 초기화
        System.out.println("optVal3 = " + optVal3);

        // optVal에 저장된 값 반환
        String str1 = optVal.get(); // null 이면 예외 발생 -> get 잘 안쓴다!!!!!!!!!!! 사용하려면 예외처리
        String str2 = optVal.orElse("");    // null 이면 "" 반환

        String str3 = optVal.orElseGet(String::new);
            String str4 = optVal.orElseThrow(NullPointerException::new);    // null 이면 예외

        if(Optional.ofNullable(str).isPresent()) {
            System.out.println(str);
        }
        // 동일함
        Optional.ofNullable(str).ifPresent(System.out::println);
        // 참조변수 str이 null이 아닐 때만 값을 출력, null이면 아무일도 X


        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);  // Optional에도 "map"이 있다!
        System.out.println("optStr.get() = " + optStr.get());
        System.out.println("optInt.get() = " + optInt.get());

        int result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).get();
        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)    // "" 조건을 통과하지 못하여 null이 된다
                .map(Integer::parseInt).orElse(-1);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x-> System.out.printf("result3=%d%n",x));

        OptionalInt opt = OptionalInt.of(0);
        OptionalInt opt2 = OptionalInt.empty();
        System.out.println("opt.isPresent() = " + opt.isPresent());
        System.out.println("opt2.isPresent() = " + opt2.isPresent());

        System.out.println(opt.getAsInt());
//        System.out.println(opt2.getAsInt());
        System.out.println("opt = " + opt);
        System.out.println("opt2 = " + opt2);
        System.out.println("opt.equals(opt2)?"+opt.equals(opt2));

    }
}
