# Group4

1. 把兩份txt檔內的SQL指令貼到group4帳號內創表格（測試連線正常用）
2. import專案，然後強制maven更新
3. 執行webcontent下的loginsystem.jsp
4. 如果畫面顯示和測試正常，就可以複製自己的package進來開始進行開發
5. group4 package下的model controller是上課範例，之後整合完畢會刪除

如果是單純在xml內新增設定，可以直接在xml內新增並加註解讓大家理解用途，最後在pull request時直接合併
若是修改設定檔的原有內容，可以直接提出

命名規範：
A：程式碼
1. tw.group4下面一層新增_座號_的package
2. _座號_下面再依功能自行定義package區分
3. WEB-INF底下新增座號名的資料夾
4. 座號名的資料夾下再依功能自己定義要怎麼放jsp檔
B：網址
1. Requestmapping和return一律前面加上座號/
2. 若該網址需要啟動hibernate，網址後一律加上.ctrl
