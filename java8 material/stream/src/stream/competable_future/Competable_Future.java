package stream.competable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/*
 * java.util.concurrent.CompletableFuture is a Future in java 8 which is the derived class of java.util.concurrent.CompletionStage.
 *  CompletableFuture can be completed setting value and status explicitly.
 *   There are different methods in CompletableFuture that can be used to handle task. 
 *   example of some methods like supplyAsync, thenApply, join, thenAccept, whenComplete and getNow.
 
 1. A Future that may be explicitly completed (setting its value and status), and may be used as a CompletionStage, supporting dependent functions and actions that trigger upon its completion. 

2. When two or more threads attempt to complete, completeExceptionally, or cancel a CompletableFuture, only one of them succeeds. 

3. In addition to these and related methods for directly manipulating status and results, 
       CompletableFuture implements interface CompletionStage with the following policies: 

4. Actions supplied for dependent completions of non-async methods may be performed by the thread that completes the current CompletableFuture, or by any other caller of a completion method. 
5. All async methods without an explicit Executor argument are performed using the 
         ForkJoinPool.commonPool() .
  6. To simplify monitoring, debugging, and tracking, all generated asynchronous tasks are 
          instances of the marker interface AsynchronousCompletionTask. 

7. All CompletionStage methods are implemented independently of other public methods, 
   so the behavior of one method is not impacted by overrides of others in subclasses. 
CompletableFuture also implements Future with the following policies: 

Since (unlike FutureTask) this class has no direct control over the computation that causes it to be completed, cancellation is treated as just another form of exceptional completion. Method cancel has the same effect as completeExceptionally(new CancellationException()). Method isCompletedExceptionally can be used to determine if a CompletableFuture completed in any exceptional fashion. 
In case of exceptional completion with a CompletionException, methods get() and get(long, TimeUnit) throw an ExecutionException with the same cause as held in the corresponding CompletionException. To simplify usage in most contexts, this class also defines methods join() and getNow that instead throw the CompletionException directly in these cases. 

 */

public class Competable_Future {
	public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Arrays.asList(10,20,30,40);
        
        //stage.thenApply(x -> square(x)).thenAccept(x -> System.out.print(x)).thenRun(() -> System.out.println()). 
        
        list.stream().map(data->CompletableFuture.supplyAsync(()->getNumber(data))).
                map(compFuture->compFuture.thenApply(n->n*n)).map(t->t.join())
                .forEach(s->System.out.println(s));
        
        list.stream().map(data->CompletableFuture.supplyAsync(()->"Processing:"+data)).
        map(compFuture->compFuture.thenAccept(s->System.out.println(s))).map(t->t.join())
        .count();
        
       long gg= list.stream().map(s->CompletableFuture.supplyAsync(()->s+s))
        .map(f->f.whenComplete((result,error)->System.out.println(result+" Error:"+error))).count();
        
        System.out.println(gg);
     //   list.stream().map(s->CompletableFuture.supplyAsync(()->s+s))        .map(f->f.getNow("Not Done")).forEach(s->System.out.println(s));
        
    }
    private static int getNumber(int a){
        return a*a;
    }
}
