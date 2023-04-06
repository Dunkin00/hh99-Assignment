import java.util.*;
public class A02_week02 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in); // System.in으로 값을 입력 받는다.
            String type = sc.nextLine();         // type을 입력 받는다. .next()로 입력을 받으면 다음
            String title;                        // title = sc.nextLine()을 수행하지 않고 넘어가버린다.

            switch (type) {                      // 입력 받은 값에 따라 다른 방식으로 저장할 수 있도록 switch문 사용
                case "List":
                    title = sc.nextLine();
                    ArrayList<String> strList = new ArrayList<String>();
                    while (true) {
                        String recipe = sc.nextLine();
                        if (recipe.equals("끝")) {
                            break;
                        } else {
                            strList.add(recipe);
                        }
                    }
                    System.out.println("[ " + type + " 으로 저장된 " + title + " ]");
                    for (int i = 0; i < strList.size(); i++) {
                        System.out.println((i + 1) + ". " + strList.get(i));
                    }
                    break;
                case "Set":
                    title = sc.nextLine();
                    LinkedHashSet<String> strSet = new LinkedHashSet<>(); // 선언
                    while (true) {
                        String recipe = sc.nextLine();
                        if (recipe.equals("끝")) {
                            break;
                        } else {
                            strSet.add(recipe);
                        }
                    }
                    Iterator iterator = strSet.iterator();
                    System.out.println("[ " + type + " 으로 저장된 " + title + " ]");
                    for (int i = 0; i < strSet.size(); i++) {
                        System.out.println((i + 1) + ". " + iterator.next());
                    }
                    break;
                case "Map":
                    title = sc.nextLine();
                    Map<Integer, String> strMap = new HashMap<>();
                    int keyNum = 0;
                    while (true) {
                        String recipe = sc.nextLine();
                        if (Objects.equals(recipe, "끝")) {
                            break;
                        }
                        strMap.put(keyNum++, recipe);
                    }
                    System.out.println("[ " + type + " 으로 저장된 " + title + " ]");
                    for (int i = 0; i < strMap.size(); i++) {
                        System.out.println((i + 1) + ". " + strMap.get(i));
                    }
                    break;
                default:
                    System.out.println("입력 값이 올바르지 않습니다.");
            }
            sc.close();
        }
}

