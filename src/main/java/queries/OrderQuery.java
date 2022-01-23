package queries;

public class OrderQuery {
    public static final String updateStatusQuery = "update Order o set o.status = ?1 where o.Id = ?2";
}
