1. 안드로이드 특징
  - 공개 운영체제 `리눅스`기반
  - `java`, 'kotlin' 으로 개발
  - 대부분 코드가 오픈( 핵심 코드, 라이브러리 )
  - 파편화, 멀티태스킹

2. 안드로이드 플랫폼 아키텍처

  > 안드로이드 아키텍처
  - 리눅스 커널 기반
  - 자바 API 프레임워크에 하드웨어 기능이용하는 표준
  - Android Runtime : ART 가상 머신을 이용하며 그 위에 애플리케이션 개발
    `ArrayList`는 앱을 실핼할 떄 DEX 파일 실행

  ![alt](https://developer.android.com/studio/images/write/desugar_2x.png)


3. 컴포넌트 기반 개발
  - 컴포넌트 : 앱의 구성 단위, 여러개의 컴포넌트를 조합하여 하나의 앱을 구성
  - 즉, 물리적인 모습은 `클래스`
  - 앱 내에서 독립적으로 실행하는 단위
  - `인텐트` 라는 것을 매개로 하여 결합하지 않은 상태에서 <u>독립적으로 실행</u>

  > 안드로이드 컴포넌트 종류
  - `Activity` : UI를 구성하기 위한 컴포넌트
  - `Service` : UI 없이 백그라운드에서 장시간 수행되는 컴포넌트
  - `ContentProvider` : 애플리케이션 간 데이터를 공유하기 위한 컴포넌트
  - `BroadcastReceiver` : 이벤트 모델로 수행되는 컴포넌트


4. gradle 파일
  - 안드로이드 빌드 도구
  - `setting.gradle` : 그레들에 모듈을 포함하여 그레이들이 모듈을 관리하고 빌드하게 설정
  - `build.gradle` : `Gradle Scripts` 영역의 최상위 , 모듈을 위한 최상위 설정을 목적, 프로젝트 수준의 그레들
  - 모듈 수준의 그레이들
  ~~~java

  android {
      compileSdkVersion 27 // 사용하는 컴파일러 버전
      defaultConfig {
          applicationId "com.example.user.myapplication" // 앱의 식별자
          minSdkVersion 19 // 최소 지원 범위
          targetSdkVersion 27 // 사용하고 있는 SDK 버전
          versionCode 1 // 앱의 버전
          versionName "1.0"
          testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
      }

      dependencies{ // 앱을 위한 라이브러리 등록

      }

  ~~~
