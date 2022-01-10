package commonsolutions.design.func.page;

import lombok.Data;

import java.util.Objects;

@Data
public class PageDTO {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 条数
     */
    private Integer pageSize;
    /**
     * 分页初始条数
     */
    private Integer pageStart;

    public void checkAndSetup() {
        if (Objects.isNull(pageNum) || pageNum <= 0) {
            pageNum = 1;
        }
        if (Objects.isNull(pageSize) || pageSize <= 0) {
            pageSize = 10;
        }
        pageStart = (pageNum - 1) * pageSize;
    }
}
