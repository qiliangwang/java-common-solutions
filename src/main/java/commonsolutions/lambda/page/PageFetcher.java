package commonsolutions.lambda.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.function.Function;

public class PageFetcher<C extends PageDTO, T> extends AbstractPageFetcher {

    private Function<C, List<T>> listFunc;
    private Function<C, Long> countFunc;

    public PageFetcher(C condition, Function<C, List<T>> listFunc, Function<C, Long> countFunc) {
        super(condition);
        this.listFunc = listFunc;
        this.countFunc = countFunc;
    }

    public static <C extends PageDTO, T> PageFetcher<C, T> of (C condition, Function<C, List<T>> listFunc, Function<C, Long> countFunc) {
        return new PageFetcher<>(condition, listFunc, countFunc);
    }


    @Override
    @SuppressWarnings("all")
    protected void setupRecordsAndTotal(Page page) {
        page.setRecords(listFunc.apply((C) condition));
        page.setTotal(countFunc.apply((C) condition));
    }
}
