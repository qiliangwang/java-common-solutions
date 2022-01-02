package commonsolutions.design.func.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * C 查询对象类型 Ｔ返回列表类型
 * @param <C>
 * @param <T>
 */
public abstract class AbstractPageFetcher<C extends PageDTO, T> {

    protected C condition;

    public AbstractPageFetcher(C condition) {
        this.condition = condition;
    }

    public IPage<T> page() {
        condition.checkAndSetup();
        return retrievePage();
    }

    private IPage<T> retrievePage() {
        Page<T> page = new Page<>();
        page.setCurrent(condition.getPageNum());
        page.setSize(condition.getPageSize());
        setupRecordsAndTotal(page);
        return page;
    }

    protected abstract void setupRecordsAndTotal(Page<T> page);

}
