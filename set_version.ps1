param (
	[Parameter(Position = 0, Mandatory = $true)][String] $version
)

mvn versions:set -DnewVersion="$version"