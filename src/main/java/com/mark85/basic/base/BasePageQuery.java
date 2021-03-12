package com.mark85.basic.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author wuxianshou
 * @date 2020-02-11 20:02
 */
@ApiModel("分页条件")
public class BasePageQuery implements Serializable {
    private static final long serialVersionUID = -2097888158308259526L;

    private static final Integer DEFAULT_PAGE_SIZE = 20;

    private static final Integer DEFAULT_FIRST_PAGE = 1;

    private static final Integer DEFAULT_TOTAL_ITEM = 0;

    @ApiModelProperty(hidden = true)
    private Integer totalItem;

    @ApiModelProperty(value = "每页数量，默认20", example = "20", position = 1)
    private Integer pageSize;

    @ApiModelProperty(value = "分页页码，默认1", example = "1", position = 2)
    private Integer currentPage;

    @ApiModelProperty(hidden = true)
    private Integer limit;

    @ApiModelProperty(hidden = true)
    private Integer offset;

    @ApiModelProperty(hidden = true)
    private int startRow;

    @ApiModelProperty(hidden = true)
    private int endRow;

    @ApiModelProperty(hidden = true)
    private int startIndex;

    /**
     * @return Returns the defaultPageSize.
     */
    protected Integer getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    @ApiModelProperty(hidden = true)
    public boolean isFirstPage() {
        return this.getCurrentPage() == 1;
    }

    @ApiModelProperty(hidden = true)
    public int getPreviousPage() {
        int back = this.getCurrentPage() - 1;

        if (back <= 0) {
            back = 1;
        }

        return back;
    }

    @ApiModelProperty(hidden = true)
    public boolean isLastPage() {
        return this.getTotalPage() == this.getCurrentPage();
    }

    @ApiModelProperty(hidden = true)
    public int getNextPage() {
        int back = this.getCurrentPage() + 1;

        if (back > this.getTotalPage()) {
            back = this.getTotalPage();
        }

        return back;
    }

    /**
     * @return Returns the currentPage.
     */
    public Integer getCurrentPage() {
        if (currentPage == null) {
            return DEFAULT_FIRST_PAGE;
        }

        return currentPage;
    }

    /**
     * @param cPage The currentPage to set.
     */
    public void setCurrentPage(Integer cPage) {
        if ((cPage == null) || (cPage <= 0)) {
            this.currentPage = null;
        } else {
            this.currentPage = cPage;
        }
        setStartEndRow();
    }

    @ApiModelProperty(hidden = true)
    public void setCurrentPageString(String pageString) {
        if (isBlankString(pageString)) {
            this.setCurrentPage(DEFAULT_FIRST_PAGE);
        }

        try {
            Integer integer = new Integer(pageString);

            this.setCurrentPage(integer);
        } catch (NumberFormatException ignore) {
            this.setCurrentPage(DEFAULT_FIRST_PAGE);
        }
    }

    @ApiModelProperty(hidden = true)
    private void setStartEndRow() {
        this.startRow = this.getPageSize() * (this.getCurrentPage() - 1) + 1;
        this.startIndex = this.getPageSize() * (this.getCurrentPage() - 1);
        this.endRow = this.startRow + this.getPageSize() - 1;
    }

    /**
     * @return Returns the pageSize.
     */
    public Integer getPageSize() {
        if (pageSize == null) {
            return getDefaultPageSize();
        }

        return pageSize;
    }

    /**
     * @param pSize The pageSize to set.
     */
    public void setPageSize(Integer pSize) {
        if ((pSize == null) || (pSize <= 0)) {
            this.pageSize = null;
        } else {
            this.pageSize = pSize;
        }
        setStartEndRow();
    }

    @ApiModelProperty(hidden = true)
    public boolean hasSetPageSize() {
        return pageSize != null;
    }

    @ApiModelProperty(hidden = true)
    public void setPageSizeString(String pageSizeString) {
        if (isBlankString(pageSizeString)) {
            return;
        }

        try {
            Integer integer = new Integer(pageSizeString);

            this.setPageSize(integer);
        } catch (NumberFormatException ignore) {
        }
    }

    /**
     * @param pageSizeString
     * @return
     */
    @ApiModelProperty(hidden = true)
    private boolean isBlankString(String pageSizeString) {
        if (pageSizeString == null) {
            return true;
        }

        if (pageSizeString.trim().length() == 0) {
            return true;
        }

        return false;
    }

    /**
     * @return Returns the totalItem.
     */
    @ApiModelProperty(hidden = true)
    public Integer getTotalItem() {
        if (totalItem == null) {
            //throw new IllegalStateException("Please set the TotalItem
            // frist.");
            return DEFAULT_TOTAL_ITEM;
        }

        return totalItem;
    }

    /**
     * @param tItem The totalItem to set.
     */
    @ApiModelProperty(hidden = true)
    public void setTotalItem(Integer tItem) {
        if (tItem == null) {
            throw new IllegalArgumentException("TotalItem can't be null.");
        }

        this.totalItem = tItem;

        int current = this.getCurrentPage();
        int lastPage = this.getTotalPage();

        if (current > lastPage) {
            this.setCurrentPage(lastPage);
        }
    }

    @ApiModelProperty(hidden = true)
    public int getTotalPage() {
        int pgSize = this.getPageSize();
        int total = this.getTotalItem();
        int result = total / pgSize;

        if ((total == 0) || ((total % pgSize) != 0)) {
            result++;
        }

        return result;
    }

    /**
     * Frist是first写错了 历史原因，不改了
     *
     * @return
     */
    @ApiModelProperty(hidden = true)
    public int getPageFristItem() {
        int cPage = this.getCurrentPage();

        if (cPage == 1) {
            // 第一页开始当然是第 1 条记录
            return 1;
        }

        cPage--;

        int pgSize = this.getPageSize();

        return (pgSize * cPage) + 1;
    }

    @ApiModelProperty(hidden = true)
    public int getPageLastItem() {
        int cPage = this.getCurrentPage();
        int pgSize = this.getPageSize();
        int assumeLast = pgSize * cPage;
        int totalItem = getTotalItem();

        if (assumeLast > totalItem) {
            return totalItem;
        } else {
            return assumeLast;
        }
    }

    /**
     * @return Returns the endRow.
     */
    @ApiModelProperty(hidden = true)
    public int getEndRow() {
        return endRow;
    }

    /**
     * @param endRow The endRow to set.
     */
    @ApiModelProperty(hidden = true)
    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    /**
     * @return Returns the startRow.
     */
    @ApiModelProperty(hidden = true)
    public int getStartRow() {
        return startRow;
    }

    /**
     * @param startRow The startRow to set.
     */
    @ApiModelProperty(hidden = true)
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    /**
     * 判断是否有下一页, 并且设置当前页码为下一页
     *
     * @return boolean
     */
    @ApiModelProperty(hidden = true)
    public boolean nextPage() {
        if (this.currentPage != null && this.currentPage >= this.getTotalPage()) {
            return false;
        }
        if (this.currentPage == null) {
            this.setCurrentPage(DEFAULT_FIRST_PAGE);
        } else {
            this.setCurrentPage(getNextPage());
        }
        return true;
    }

    @ApiModelProperty(hidden = true)
    public int getStartIndex() {
        return startIndex;
    }

    @ApiModelProperty(hidden = true)
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @ApiModelProperty(hidden = true)
    public Integer getLimit() {
        return limit;
    }

    @ApiModelProperty(hidden = true)
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @ApiModelProperty(hidden = true)
    public Integer getOffset() {
        return offset;
    }

    @ApiModelProperty(hidden = true)
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

}
