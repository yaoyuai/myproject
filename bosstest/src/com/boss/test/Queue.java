package com.boss.test;

public interface Queue<T>{

    /*
     *
     * @author yaoyu
     * @date 2022/6/11 14:21
     * @param data
     * @return boolean
     */
    boolean add(T data);// 加入失败抛出异常

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 14:21
     * @param data 
     * @return boolean
     */
    boolean offer(T data);//加入失败返回false

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 14:21 
     * @return T
     */
    T remove();//移除队首 如果队列空则抛出异常

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 14:21 
     * @return T
     */
    T poll();//移除队首

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 14:21 
     * @return T
     */
    T element();//取得队首元素

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 14:28
 * @return T
     */
    T peek();// 取得队首元素如果队列为空则抛出异常
}
