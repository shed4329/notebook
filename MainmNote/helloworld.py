from manim import *
import numpy as np

# Scene 场景
# Mobject 物体
# Animation 动画

# Scene包括Mobject和Animation,由场景控制这些东西完成整个动画的逻辑
# Animation需要一个动画的承受者

# There's 3 version of manim,each version have different argument
# for community version,-ql -p(preview low quality)
# Argument:
# -p:preview automatically open the file when it finished
# -l:low_quality
# -m(short for -medium_quality)
# -high_quality

# 也可以继承一下别的Scene，GraphScene已经没有了
# 觉得丑可以改配置
# Down快捷写法([0,-1,0])
# class MyScene(ThreeDScene):
#    def construct(self):
#        self.setup()
class HelloWorld(Scene):
    def construct(self):
        # Mobject
        # Tex纯文本，只能用无衬线字体
        # TexObject可以渲染公式，但这个版本没有
        # 用Latex渲染公式
        # \为string转义，到latex就没了\,可以在前面加r，或者用\\
        text2 = Tex(r"$ABC\frac{1}{x}$")
        # 父类Scene的play方法
        text = Text("Hello World!")
        self.play(
            # Write动画，Text承受者，play方法播放
            Write(text)
        )

        # Mobject.shift(),need a numpy vector
        # shift移动Mobject的位置
        # shift(),scale()返回的都是自己，不用其他步骤，直接.调用
        # 变大2倍
        # rotate()旋转默认用弧度
        # rotate_about_origin()绕原点旋转
        # 方法都在Mobject里，自己去试
        text2.shift(np.array([0,-1,0])).scale(2).rotate(3.14)
        # 播放完文字1后再添加文字2
        # xxx在Hello World!上面
        # 实测添加是没有动画的
        self.add(text2)

        # 群组，和在一起
        text_group = VGroup()
        text_group.add(text)
        text_group.add(text2)
        self.play(ApplyMethod(text_group.shift,np.array([0,1,0])))
        self.play(ApplyMethod(text_group.rotate,30))
        # 包裹对应对象
        square = Square().surround(text2)
        # ApplyMethod，运用方法，出现时添加动画
        self.play(ApplyMethod(square.scale,2))
        # 动画 animation文件夹下
        # Write一个一个写出，DrawBorderThenFill（Write的父类),全部写出
        # FadeIn 淡入 FadeInFromLarge 淡入+由大变小
        # 播放完1后等待2s，这样文字2的效果就可以持续2s
        # 坐标轴
        xOyPlane = NumberPlane()
        # 画函数与文档似乎不一样，不画了
        # 还可以给函数加标签
        # 旧版是showCreation添加图像
        # 还有画水平，竖直线的方法
        self.add(xOyPlane)
        self.wait(2)