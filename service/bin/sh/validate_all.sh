#!/bin/bash
#
#                               .__
# ______      ____ ______  __ __|  |   ____      __ __  ______
# \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
# |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
# |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
# |__|    \/       |__|                      \/            \/
#
#
# Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
# All Rights Reserved.
#
# This software is licensed under The MIT License (MIT)
# http://opensource.org/licenses/MIT
#
# The MIT License (MIT)
#
# Permission is hereby granted, free of charge, to any person obtaining
# a copy of this software and associated documentation files (the
# "Software"),
# to deal in the Software without restriction, including without
# limitation the rights to use, copy, modify, merge, publish,
# distribute, sublicense,
# and/or sell copies of the Software, and to permit persons to whom the
# Software is furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be
# included in all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
# MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT
# SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
# DAMAGES OR OTHER LIABILITY,
# WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT
# OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
# THE SOFTWARE.
#

for table in Cities CountryLanguages Languages Countries Infections; do
    xmllint --noout --schema src/main/resources/xsd/$table.xsd src/main/resources/xml/$table.xml
done;
