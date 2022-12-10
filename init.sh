#!/bin/bash

# input
read -p "Input project groups ( ex \"com.kshired\" ): " groups
read -p "Input project name ( ex \"example-project\" ): " projectName

# kebab case to dot case
dotCaseProjectName=${projectName//-/.}

# change all files package name
echo "Change all files package name from \"com.kshired.boilerplate\" to \"${groups}.${dotCaseProjectName}\""
regexForChangePackage="s/com.kshired.boilerplate/${groups}.${dotCaseProjectName}/g"
find . -name "*.kt" -exec perl -pi -e ${regexForChangePackage} {} \; 2>/dev/null

# change project name
echo "Change project name from \"example-project\" to \"$projectName\""
regexForChangeProjectName="s/example-project/${projectName}/g"
find . -name "*.kts" -exec perl -pi -e ${regexForChangeProjectName} {} \; 2>/dev/null

# change project groups
echo "Change project groups from \"com.kshired\" to \"$groups\""
regexForChangeProjectGroup="s/com.kshired/${groups}/g"
find . -name "*.properties" -exec perl -pi -e ${regexForChangeProjectGroup} {} \; 2>/dev/null

# set sub directories
subDirectories=${groups//./\/}/${dotCaseProjectName//./\/}

# create all sub directories
echo "Create all directories \"${groups}.${dotCaseProjectName}\""
createSubDirectoriesCommand="mkdir -p \$1/${subDirectories}"
find . -type d -name "kotlin" -exec bash -c "$createSubDirectoriesCommand" - '{}' \; 2>/dev/null

# move all directories and files
echo "Move directories from \"com.kshired.boilerplate\" to \"${groups}.${dotCaseProjectName}\""
moveDirectoriesCommand="mv -v \$1/com/kshired/boilerplate/* \$1/${subDirectories} && rm -rf \$1/com/kshired/boilerplate"
find . -type d -name "kotlin" -exec bash -c "$moveDirectoriesCommand" - '{}' \; 2>/dev/null

# cleaning all useless directories
find . -name ".DS_Store" -type f -delete 2>/dev/null
find . -type d -name "kshired" -empty -exec rmdir {} \; 2>/dev/null
find . -type d -name "com" -empty -exec rmdir {} \; 2>/dev/null