$(document).ready(function() {window.b2233 = new B2233(".b2233_wrp");b2233.init();});

var animation = {
    plus: function(target, direction, callback) {
        var target = $(target), start, end, opacityStart = 0;
        if(direction == "down") {
            start = 140;
            end = 24;
            opacityStart = 1;
        } else {
            start = 24;
            end = 140;
        }
        target.stop().show().css({
            "bottom": start,
            "opacity": opacityStart
        }).animate({
            bottom: end,
            opacity: 1
        }, 300, function() {
            if (callback) {
                callback();
            }
            target.animate({
                "opacity": "0"
            }, 200, function() {
                $(this).hide();
            });
        });
    },
    move: function(item, direct, shift, dur) {
        var origin = parseInt(item.css(direct));
        var data = {
            "opacity": "1"
        };
        data[direct] = origin + shift;
        item.animate(data, dur);
    },
    start: function() {
        $(".b-22,.b-33").css("visibility", "visible");
        $(".b-22,.b-33").animate({
            top: -325
        }, 1000);
        $(".b-22,.b-33").animate({
            top: -310
        }, 100);
        $(".b-22,.b-33").animate({
            top: -320
        }, 100, function() {
            $(".b-22,.b-33").css("z-index", 8000);
        });
    }
};

//2233
var B2233 = function(target, randomTxt) {
    this.dlg = {
        b22: {
            text: ["bilibilibi~", "祝大家羊年行大运！", "恭喜发财，新春快乐", "咩咩咩~", "(゜-゜)つロ 乾杯~", "新的一年也要加油哦", "biubiubiu~", "一起努力吧(((o(*ﾟ▽ﾟ*)o)))", "嘿！新年快乐 咩！", "ヾ(*´▽‘*)ﾉ 喜洋洋！", "新年新气象！", "新年好呀新年好~\(≧▽≦)/~啦啦啦", "嘿！w", "新年FIHGT 达哟！", "新年快乐！咩！＼（‾︶‾）／", "什么？！没有红包！咩！Σ( ° △ °|||)︴", "羊年吉祥，喜气羊羊~", "羊眉吐气╰(*°▽°*)╯", "不要开小差！好好看拜年祭！", "点我也不会给你辣条的！", "戳累了，看个视频吧..", "绅士！", "再戳也不会给福利的，哼", "呀，钱包被你戳掉了！", "咩，羊年吉祥！~", "不要戳奇怪的地方哟~ ", "新年找个女盆浴 ", "新年快乐！咩~~~", "羊年吉祥！", "新年行大运~~", "新年也请多多关照了", "过年最重要的就是开心！", "新年快乐！羊年大吉！", "戳我22下会有好运哦~", "咩咩咩~祝大家羊年心想事成哦！"],
            ex: "二三二三二~直戳你心的2233娘~",
            index: 0,
            count: 0
        },
        b33: {
            text: ["咩...", "不要再点我啦", "新的一年里大家也要继续做个好孩子哟 ", "喜。。。气羊羊", "(゜-゜)つロ 乾杯~", "chi～～～盯", "给我糖......", "  (;¬_¬)...盯...", "(￣へ￣)不要点啦.", " ...干嘛？", "新..新年好..", "唔...新年好", "不要再点了...", "不要点我了...谁来救救我 姐姐", "咩~~~", "……", "咩咩咩……", "还…还没点够嘛……", "不要看我……看拜年祭……", "不要...盯着我看~", "羊羊羊~羊年大吉！", "哈秋，好冷啊~", "咩~咩~", "说了等等>_<  ", "新年快乐", "点我也不会理你的咩", "边吃边看。。。会变胖的", "不要戳我，会发生奇怪的事的", "为什么又戳我~", "红包会有的。。。"],
            ex: "二三二三二~直戳你心的2233娘~",
            index: 0,
            count: 0
        }
    };
    this.image = {
        b22: {
            ele: $(".left_22"),
            textEle: $("#l_22"),
            data: ["background-position,-290px -12px", "background-position,-590px -12px", "background-position,-890px -12px", "background-position,10px -12px"],
            spData: {
                50: {
                    bg: "background-position,-1190px -12px",
                    txt: ["Bilibili BI~直戳你心的Bilibili BI~", "二三二三二~直戳你心的2233娘~"]
                }
            },
            count: 0
        },
        b33: {
            ele: $(".right_33"),
            textEle: $("#r_33"),
            data: ["background-position,28px -699px", "background-position,-277px -699px", "background-position,-582px -699px", "background-position,-887px -699px"],
            spData: {
                50: {
                    bg: "background-position,-1172px -699px",
                    txt: ["点我也不会理你的咩", "二三二三二~直戳你心的2233娘~"]
                }
            },
            count: 0
        }
    };
    this.area = {
        b22: {
            areas: [{
                range: {
                    x: [150, 210],
                    y: [180, 210]
                }
            },{
                range: {
                    x: [140, 210],
                    y: [300, 350]
                }
            }],
            data: [{
                img: ["background-position,10px -12px"],
                txt: ["不要戳奇怪的地方哟~ "]
            }]
        },
        b33: {
            areas: [{
                range: {
                    x: [125, 170],
                    y: [170, 190]
                }
            },{
                range: {
                    x: [110, 180],
                    y: [280, 320]
                }
            },{
                range: [{
                    x: [130, 140],
                    y: [92, 101]
                },{
                    x: [162, 179],
                    y: [82, 96]
                }],
                data: [{
                    img: ["background-position,-582px -699px"],
                    txt: ["戳到眼睛啦！~T  T"]
                }]
            }],
            data: [{
                img: ["background-position,28px -699px"],
                txt: ["(￣へ￣)不要点啦."]
            },{
                img: ["background-position,-887px -699px"],
                txt: ["还…还没点够嘛……"]
            }]
        }
    };
    this.spDlgs = {};
    this.spDlg = null;
    this.target = $(target) || $('body');
    this.useExTxt = false;
    this.randomTxt = randomTxt || true;
    this.useAreaEffect = true;
    this.click = 0;
    this.timer = {
        b22: null,
        b33: null
    };
};
B2233.prototype = {
    init: function() {
        var _b2233 = this;
        $(".left_22, .right_33", this.target).click(function(e) {
            var m = $(this);
            var target = _b2233.target;
            var type = m.attr("type");
            clearTimeout(_b2233.timer[type]);
            _b2233.changeImg(type, e);
            var text = _b2233.makeText(type);
            if (type == "b22" && _b2233.dlg[type].count >= 22 || type == "b33" && _b2233.dlg[type].count >= 33) {
                m.removeClass("anim");
                setTimeout(function() {
                    m.addClass("anim");
                }, 0);
            }
            _b2233.showMsg(m, text, type);
        });
    },
    showMsg: function(target, text, type, timer) {
        var _b2233 = this;
        var msg = $('<div class="communication ' + type + '">' + text + '<div class="arrow"></div></div>');
        $(".communication." + type).remove();
        return msg.prependTo(target).show(0, function() {
            if (type == "b22") {
                animation.move(msg, "margin-left", 10, 300);
            } else {
                animation.move(msg, "margin-right", 10, 300);
            }
            if(timer !== false) {
                _b2233.msgTimer($(this), type);
            }
        });
    },
    checkArea: function(type, event) {
        if(!this.useAreaEffect) {
            return false;
        }
        var x = event.offsetX,
            y = event.offsetY,
            obj = this.area[type];
        for(var i=0;i<obj.areas.length;i++) {
            var config = obj.areas[i];
            var ranges = config.range;
            if(!$.isArray(ranges)) {
                ranges = [ranges];
            }
            for(var j=0;j<ranges.length;j++) {
                var range = ranges[j];
                if (x >= range.x[0] && x <= range.x[1] && y >= range.y[0] && y <= range.y[1]) {
                    if(config.data) {
                        return config.data[Math.floor(Math.random()*config.data.length)];
                    } else {
                        return obj.data[Math.floor(Math.random()*obj.data.length)];
                    }
                }
            }
        }
        return false;
    },
    makeText: function(type) {
        var dlg = this.dlg[type];
        var text = "";
        if(this.spDlg) {
            text = this.spDlg;
        } else if(this.randomTxt) {
            var n = Math.round(Math.random()*(dlg.text.length-1));
            text = dlg.text[n];
            dlg.index = n;
        } else if (dlg.count <= 9 || !this.useExTxt) {
            var n = dlg.index;
            text = dlg.text[n];
            dlg.index = dlg.index < dlg.text.length - 1 ? dlg.index + 1 : 0;
        } else {
            text = dlg.ex;
            dlg.index = 0;
        }
        dlg.count++;
        return text;
    },
    changeImg: function(type, event) {
        var _b2233 = this,
            config = this.image[type],
            data = config.data,
            spIndex = null,
            spTxt = null,
            imgIndex;
        config.count++;
        var areaEffect = this.checkArea(type, event);
        if(areaEffect) {
            data = areaEffect.img;
            spTxt = areaEffect.txt;
        } else {
            for (var i in config.spData) {
                if (config.count >= i) {
                    if(config.spData[i].bg && $.inArray(config.spData[i].bg, data) < 0) {
                        spIndex = data.push(config.spData[i].bg) - 1;
                        this.spDlgs[spIndex] = config.spData[i];
                    } else {
                        if(config.spData[i].bg) {
                            spIndex = $.inArray(config.spData[i].bg, data);
                        }
                        spTxt = config.spData[i].txt;
                    }
                    delete config.spData[i];
                }
            }
        }
        if(spIndex != null) {
            imgIndex = spIndex;
        } else {
            imgIndex = Math.floor(Math.random() * data.length);
        }
        if(this.spDlgs[imgIndex] && !spTxt) {
            spTxt = this.spDlgs[imgIndex].txt;
            this.spDlg = spTxt[Math.floor(Math.random() * spTxt.length)];
        } else if(spTxt) {
            this.spDlg = spTxt[Math.floor(Math.random() * spTxt.length)];
        } else {
            this.spDlg = null;
        }
        var imgData = data[imgIndex].split(",");

        config.ele.css(imgData[0], imgData[1]);
        config.textEle.text(config.count);
    },
    msgTimer: function(msg, type) {
        var _b2233 = this;
        _b2233.timer[type] = setTimeout(function() {
            msg.fadeOut(300, function() {
                msg.remove();
                _b2233.dlg[type].count = 0;
            });
        }, 2500);
        msg.hover(
            function() {
                clearTimeout(_b2233.timer[type]);
            },
            function() {
                _b2233.timer[type] = setTimeout(function() {
                    msg.fadeOut(300, function() {
                        msg.remove();
                        _b2233.dlg[type].count = 0;
                    });
                }, 2500);
            }
        );
    }
};