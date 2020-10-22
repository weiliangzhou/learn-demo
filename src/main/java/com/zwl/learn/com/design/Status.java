package com.zwl.learn.com.design;

public enum Status {
    /**
     * 待提交
     */
    TO_BE_SUBMIT {
        @Override
        public Status nextStatus() {
            return TO_BE_AUDIT;
        }

        @Override
        public Status voidStatus() {
            return CANCEL;
        }
    },
    /**
     * 待审核
     */
    TO_BE_AUDIT {
        @Override
        public Status nextStatus() {
            return TO_BE_SIGN;
        }

        @Override
        public Status voidStatus() {
            return TO_BE_SUBMIT;
        }
    },
    /**
     * 待签署
     */
    TO_BE_SIGN {
        @Override
        public Status nextStatus() {
            return COMPLETED;
        }
    },
    /**
     * 已取消
     */
    CANCEL,
    /**
     * 已完成
     */
    COMPLETED{
        @Override
        public Status nextStatus() {
            return TERMINATED;
        }

    },
    /**
     * 已终止
     */
    TERMINATED;

    public Status nextStatus() {
        throw new RuntimeException("没有下一个状态");
    }

    public Status preStatus() {
        throw new RuntimeException("没有下一个状态");
    }

    public Status voidStatus() {
        throw new RuntimeException("取消状态");
    }

}
