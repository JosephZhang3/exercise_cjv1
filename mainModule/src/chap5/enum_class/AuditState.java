package chap5.enum_class;

/**
 * Created by Jianghao Zhang on 2017/5/14.
 */
public enum AuditState {
    UNAUDIT(1), AUDITING(2), AUDIT_SUCCESS(3), AUDIT_FAIL(4);
    private final int statenum;

    private AuditState(int statenum) {
        this.statenum = statenum;
    }

    public int getStatenum() {
        return statenum;
    }

}
