package com.cjs.java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {

   private String func() {
      System.out.println("00000000000");
      try {
         TimeUnit.SECONDS.sleep(1);
      } catch (Exception e) {

      }
//      throw new RuntimeException("出错啦");
      return "ck9";
   }

   private void test() {
      ExecutorService executor = Executors.newFixedThreadPool(3);
      CompletableFuture.supplyAsync(() -> func(), executor).thenAccept(res -> {
         System.out.println(">>>>>>>>>>>>>>>>>");
         System.out.println(res);
      }).exceptionally(e -> {
         System.out.println(e.getMessage());
         return null;
      });

   }

   public static void main(String args[]){
      new CompletableFutureTest().test();
   }


}