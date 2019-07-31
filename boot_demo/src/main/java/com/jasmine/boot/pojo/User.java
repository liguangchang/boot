package com.jasmine.boot.pojo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author guangchang
 * @create 2019-07-30 16:24
 **/
public class User {
    private Integer id;
    private String name;
    private Integer sex;

    public User(Integer id, String name, Integer sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    public static void main(String[] args) {
        User user = new User(1, "12", 1);
        User user1 = new User(2, "13", 1);
        User user2 = new User(3, "14", 1);
        User[] arr = {user, user1, user2};

        myCompare myCompare = new myCompare();
        for (User user3 : arr) {
            System.err.println(user3);
        }
        Arrays.sort(arr, myCompare);
        for (User user3 : arr) {
            System.out.println(user3);
        }
        Arrays.sort(arr, (u1, u2) -> {
            return user1.getId() - user2.getId();
        });
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        long count = stream.filter(s -> s > 3).count();
        System.err.println(count);
        Stream<Integer> stream1 = Stream.iterate(1, x -> x + 1);
        stream1.limit(10).forEach(System.out::println);

        Stream<List<Integer>> s=Stream.of(
                Arrays.asList(1,2,3),
                Arrays.asList(2,3,4),
                Arrays.asList(3,4,5)
        );
//        Optional first = s.findFirst();
//        System.out.println(first);
        Stream<Integer> stream2 = s.flatMap(a -> a.stream());
//        stream2.forEach(a-> System.err.print(a));
        System.out.println();
//        System.err.println(stream2.max((a,b)->a-b));
//        System.err.println(stream2.count());
//        System.err.println(stream2.sorted());
//        stream2.reduce((a,b)->a+b);
        boolean parallel = stream2.isParallel();
        System.err.println(parallel);
//        System.err.println(stream2.allMatch(b->b>=1));
//        System.out.println(stream2.anyMatch(ss->ss>=5));
//        List<Integer> collect = stream2.collect(Collectors.toList());
        Integer[] objects = stream2.toArray(Integer[]::new);
        for (Integer object : objects) {
            System.err.println(object);
        }
        System.out.println(objects);
//        System.err.println(collect);
        System.err.println(IntStream.iterate(0, i -> i + 2).limit(100).filter(sss->sss%2==0).count());

    }



}

class myCompare implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o2.getId() - o1.getId();
    }
}
