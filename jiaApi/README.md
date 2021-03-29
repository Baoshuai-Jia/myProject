* util 通用的、与业务无关的，可以独立出来，可供其他项目使用。方法通常是public static，一般无类的属性，如果有，也是public static。

* service 与某一个业务有关，不是通用的。方法通常是public，通常是通过接口去调用，一般有public的类属性，使用时需要用new。

* tool 与某些业务有关，通用性只限于某几个业务类之间。方法通常是public static，一般无类的属性，如果有，也是public static。
