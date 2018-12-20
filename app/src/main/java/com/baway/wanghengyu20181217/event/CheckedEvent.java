package com.baway.wanghengyu20181217.event;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class CheckedEvent {
    private boolean checked;

    public CheckedEvent(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

}
