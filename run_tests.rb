#!/bin/sh ruby

result = if system "gradle test"
  'Fabulous'
else
  'Something borked'
end

`say #{result}`

exit 0
