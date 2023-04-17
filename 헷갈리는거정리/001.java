//배열 중복 제거 방법
//LinkedHashSet 이용

import java.util.Arrays;
import java.util.LinkedHashSet;

LinkedHashSet<String> "해쉬셋이름" = new LinkedHashSet<>(Arrays.asList("해쉬셋에 넣을 배열"));
//LinkedHashSet을 이용해서 배열을 LinkedHashSet에 넣게 되면, LinkedHashSet에서 중복값이 자동으로 제거 되고, 순서가 유지 된다.
String[] "배열이름" = "해쉬셋이름".toArray(new String[] {});
//LinkedHashSet은 배열이 아니므로, String형 배열에 해쉬셋에 담겨 있는 내용들을 집어 넣어준다.
