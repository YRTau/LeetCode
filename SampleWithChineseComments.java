public class SampleWithChineseComments {
    // 这是一个测试类，用于验证中文注释是否能正确读取
    private int value;
    
    /**
     * 构造函数
     * @param value 初始值
     */
    public SampleWithChineseComments(int value) {
        this.value = value; // 设置初始值
    }
    
    /**
     * 获取当前值
     * @return 当前值
     */
    public int getValue() {
        // 返回存储的值
        return value;
    }
    
    /**
     * 设置新值
     * @param value 新值
     */
    public void setValue(int value) {
        // 更新存储的值
        this.value = value;
    }
    
    /**
     * 主方法，用于测试
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建对象实例
        SampleWithChineseComments sample = new SampleWithChineseComments(10);
        
        // 输出当前值
        System.out.println("当前值: " + sample.getValue());
        
        // 修改值
        sample.setValue(20);
        
        // 再次输出
        System.out.println("更新后的值: " + sample.getValue());
    }
}