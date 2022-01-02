package commonsolutions.design.func.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ParallelPageFetcher<C extends PageDTO, T> extends AbstractPageFetcher {

    private Function<C, List<T>> listFunc;
    private Function<C, Long> countFunc;

    public ParallelPageFetcher(C condition, Function<C, List<T>> listFunc, Function<C, Long> countFunc) {
        super(condition);
        this.listFunc = listFunc;
        this.countFunc = countFunc;
    }

    public static <C extends PageDTO, T> ParallelPageFetcher<C, T> of (C condition, Function<C, List<T>> listFunc, Function<C, Long> countFunc) {
        return new ParallelPageFetcher<>(condition, listFunc, countFunc);
    }


    @Override
    @SuppressWarnings("all")
    protected void setupRecordsAndTotal(Page page) {
        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> page.setRecords(listFunc.apply((C) condition))),
                CompletableFuture.runAsync(() -> page.setTotal(countFunc.apply((C) condition)))
        ).join();
    }

    public static void main(String[] args) {
        ParallelPageFetcher<PageDTO, Integer> pageFetcher = ParallelPageFetcher.of(new PageDTO(), ParallelPageFetcher::listFunc, ParallelPageFetcher::countFunc);
        pageFetcher.page();
    }

    private static List<Integer> listFunc(PageDTO condition) {
        return new ArrayList<>();
    }

    private static Long countFunc(PageDTO condition) {
        return 0L;
    }
}
