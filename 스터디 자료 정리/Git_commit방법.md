# Git commit

- 지옥에서 건져올리는 git 커밋, 충돌 해결 방법


### New Branch 에서 Master 로 수정된 코드 병합 방법


1. new branch :suji 에서 원하는 파일을 수정한다.

    ![1](https://user-images.githubusercontent.com/26784875/53694295-2e50bf80-3df0-11e9-9edf-ebee2519ec55.png)

2. `Team`-`Add to Index` 클릭, `Team`-`Commit` 클릭 : 메시지 입력후 `commit`

    ![image](https://user-images.githubusercontent.com/26784875/53694347-e9795880-3df0-11e9-9835-80097488aaf8.png)

3. `Team`-`Switch-to`-`master` 로 변경

    ~~~ c
    :git log --branches --graph --decorate --oneline
    * 3fcb889 (suji) index<ED><8C><8C><EC><9D><BC>, suji<EC><97><90><EC><84><9C> <EC><88><98><EC><A0><95>
    * fa9ab6a (HEAD -> master) master to suji commit
    *   2ccd800 (origin/master) Merge branch 'master' of https://github.com/lhh4165/WaProject.git
    |\
    ~~~

4. `Team`-`merge` - `suji` 선택 -> `MERGE`

    ![image](https://user-images.githubusercontent.com/26784875/53694451-8be60b80-3df2-11e9-92f5-5016bd055259.png)

5. 결과

    ![image](https://user-images.githubusercontent.com/26784875/53694471-e67f6780-3df2-11e9-99e7-be375f5a7219.png)



_______________________________________________________________________________


### master to origin

- `master` 에서 보면 push, pull 상태를 볼수 있음 

~~~c
    WaProject master 2 up 1 down
~~~

- `Team`-`commit`-`push` 작업을 하면 origin으로 결과 전달

- 다른 방법

Source Tree에서 파일 커밋, 푸시 작업 
- 이 방법이 더 easy ㅜㅜㅜ


### `master` to `new branch`

- master에서 commit
- `team`-`switch to` -`suji`
- `team`-`merge`

### 중요한 점

팀프로젝트를 할 때, 
    - master로 변경된 다른 팀원의 소스를 받고 코드 작업은 다른 브랜치로 작업하고 변경하여 merge하기 


### 충돌

master에서 다른 팀원이 올린 소스를 pull 하는 작업에서
충돌이 생길수 있음.

1. pull 작업을 완료한다.
2. `team` - `merge-tool`를 이용해 충돌 부분 소스 수정
3. commit- push 


- 참고 사이트 : https://confluence.curvc.com/pages/viewpage.action?pageId=6162682





