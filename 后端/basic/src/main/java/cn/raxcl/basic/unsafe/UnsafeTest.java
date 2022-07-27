package cn.raxcl.basic.unsafe;


import sun.misc.Unsafe;

import java.lang.reflect.Field;


/**
 * @author D30100_chenlong
 * date 2022/7/20 12:07
 */
public class UnsafeTest {
    private Unsafe unsafe;
    public UnsafeTest() throws NoSuchFieldException, IllegalAccessException {
        this.unsafe = getUnsafe();
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = getUnsafe();
        UnsafeTest unsafeTest = new UnsafeTest();
        unsafeTest.fieldTest(unsafe);
        unsafeTest.memoryTest();
    }

    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        //        Unsafe unsafe = new Unsafe();
//        Unsafe unsafe = Unsafe.getUnsafe();
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        return unsafe;
    }

    public void fieldTest(Unsafe unsafe) throws NoSuchFieldException {
        User user = new User();
        // 获取字段的偏移地址（内存中的相对地址）
        long fieldOffset = unsafe.objectFieldOffset(User.class.getDeclaredField("age"));
        System.out.println("offset:" + fieldOffset);
        unsafe.putInt(user, fieldOffset, 20);
        System.out.println("age:" + unsafe.getInt(user, fieldOffset));
        System.out.println("age:" + user.getAge());
    }

    private void memoryTest() {
        int size = 4;
        // 分配一块新的内存空间
        long addr = unsafe.allocateMemory(size);
        // 重新调整内存空间
        long addr3 = unsafe.reallocateMemory(addr, size * 2);
        System.out.println("addr: " + addr);
        System.out.println("addr3: " + addr3);
        try {
            unsafe.setMemory(null, addr, size, (byte)1);
            for (int i = 0; i < 2; i++) {
                unsafe.copyMemory(null, addr, null, addr3 + size * i, 4);
            }
            System.out.println(unsafe.getInt(addr));
            System.out.println(unsafe.getLong(addr3));
        } catch (Exception e) {
            unsafe.freeMemory(addr);
            unsafe.freeMemory(addr3);
        }
    }

}
