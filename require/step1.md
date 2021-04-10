# 코틀린 DSL

## 좋은 개발 코드의 8가지 특징
- 잘 작동한다.
- 읽기 쉽다.
- 테스트 가능하다.
- 관리가 쉽다.
- 외관이 보기 좋다.
- 변경이 쉽다.
- 간결하다.
- 효율적이다.

## API가 깔끔하다
- 읽기 쉽다.
- 외관이 보기 좋다.
- 간결하다.

## 코틀린은 간결한 구문을 어떻게 지원하는가?
- 확장 함수
- 중위 호출
- 연산자 오버로딩
- get 메서드에 대한 관례
- 람다를 괄호 밖으로 빼내는 관례
- 수신 객체 지정 람다

## 도메인 특화 언어
DSL(Domain-specific language)
↔ 범용 프로그래밍 언어

- 선언적 언어
- 세부 실행은 언어를 해석하는 엔진에 맡긴다.
- 컴파일 시점에 제대로 검증하는 것이 어렵다. 
  e.g. SQL, 정규 표현식

## 코틀린 DSL
- 범용 언어(= 코틀린)로 작성된 프로그램의 일부
- 범용 언어와 동일한 문법을 사용한다.
- 호출 결과를 객체로 변환하기 위해 노력할 필요가 없다.
- 타입 안전성을 보장한다.
- 코틀린 코드를 원하는 대로 사용할 수 있다.

## 확장 함수 Extension functions
```
StringUtils.lastChar("Kotlin")

fun lastChar(s: String): Char {
    return s.get(s.length - 1)
}
```

```
"Kotlin".lastChar()

fun String.lastChar(): Char {
    return this.get(this.length - 1)
}
```

## 중위 표기 Infix notation
```
1.to("one")

fun Any.to(other: Any) = Pair(this, other)
```

```
1 to "one"

infix fun Any.to(other: Any) = Pair(this, other)
```

## 연산자 오버로딩 Operator overloading
```
Point(0, 1).plus(Point(1, 2)

data class Point(val x: Int, val y: Int) {
    fun plus(other: Point): Point = Point(x + other.x, y + other.y)
}
```

```
Point(0, 1) + Point(1, 2)

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point = Point(x + other.x, y + other.y)
}
```

## get 메서드에 대한 관례Indexed access operator
```
val names = listOf("Jason", "Pobi")
names.get(0)
names[0]
```

## 람다를 괄호 밖으로 빼내는 관례Passing a lambda to the last parameter
```
check(false, { -> "Check failed." })
```

```
check(false) { "Check failed." }
```

## 수신 객체 지정 람다 Lambda with receiver
```
val sb = StringBuilder()
sb.append("Yes")
sb.append("No")
```

```
val sb = StringBuilder()
sb.apply {
    this.append("Yes")
    append("No")
}
```

## 코틀린 DSL 실습
```
introduce {
  name("박재성")
  company("우아한형제들")
  skills {
    soft ("A passion for problem solving")
    soft ("Good communication skills")
    hard ("Kotlin")
  }
  languages {
    "Korean" level 5
    "English" level 3
  }
}
```
