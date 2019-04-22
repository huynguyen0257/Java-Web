Select tbl_Events.EventID , EventName , FromDate , ToDate
from tbl_EventUser , tbl_Events
Where tbl_EventUser.EventID = tbl_Events.EventID and tbl_EventUser.UserID = 6 and EventName LIKE '%t%'
USE PresentPRJ321
delete from tbl_EventUser Where EventID = '2' and UserID = 6
Select  tbl_Users.UserID, Fullname 
From tbl_Users , tbl_EventUser
Where tbl_Users.UserID = tbl_EventUser.UserID and EventID = 3