package 알고리즘정리2;
/*
클래스 안에 선언된 변수 -> static 이 붙지 않은 변수
인스턴스 변수는 객체 (인스턴스)를 생성해야함ㄴ 사용할 수 있는 변수
 */

public class VariableInitExample {
    //클래스 멤버 변수 (필드) -> 자동 초기화
    static int staticInt;       //기본 형 자동으로 0
    static boolean staticBool;  //기본형 자동으로 false
    static String staticStr;    //참조형 : 자동으로 null

    int instanceInt;    //인스턴스 변수도 자동 초기화
    String instanceStr; //인스턴스 변수 참조형은 null

    public static void main(String[] args){
        //static 변수는 객체 없이 바로 접근 가능
        System.out.println("staticInt = " + staticInt);
        System.out.println("staticBool = " + staticBool);
        System.out.println("staticStr = " + staticStr); //null
        
        //인스턴스 변수는 객체 생성후 접근가능
        VariableInitExample example = new VariableInitExample();
        System.out.println("instanceInt = " + example.instanceInt);
        System.out.println("instanceStr = " + example.instanceStr);
        
        //지역 변수는 자동 초기화 되지 않음 -> 반드시 직접 초기화 해야함
        int localInt;
        //System.out.println(localInt);   //컴파일 에러
    }
}
