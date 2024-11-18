package vn.com.gsoft.security.model.system;

import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @author binhk4a
 * @since Aug, 2022
 * Điều kiện phân trang
 */
@Data
public class SearchParams {
    private Integer first;
    private Integer rows;
    private String sortField;
    private Integer sortOrder;
    private String globalFilter;

    /**
     * Gets the order by clause.
     *
     * @return the order by clause
     */
    public String getOrderByClause() {
        StringBuilder sbsb = null;
        if (!StringUtils.isEmpty(this.sortField)) {
            String sortString = (1 == this.sortOrder) ? SORT_ASC : SORT_DESC;
            sbsb = new StringBuilder();
            sbsb.append(ORDER_BY).append(this.sortField).append(SPACE).append(sortString);
        }
        return (null == sbsb) ? BLANK : sbsb.toString();
    }

    /**
     * The Constant ORDER_BY.
     */
    private static final String ORDER_BY = " ORDER BY ";
    /**
     * The Constant SPACE.
     */
    private static final String SPACE = " ";
    /**
     * The Constant SORT.
     */
    private static final String SORT_ASC = "ASC";
    private static final String SORT_DESC = "DESC";
    /**
     * The Constant BLANK.
     */
    private static final String BLANK = "";
}