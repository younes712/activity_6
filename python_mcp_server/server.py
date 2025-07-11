from mcp.server.fastmcp import FastMCP

mcp = FastMCP('Python-MCP-Server')

@mcp.tool()
def get_employe_info(name : str) -> str:
    """
    Get Information about a given employee name:
    - name
    - Salary
    """
    return {
        "employe_name" : name,
        "salary":5400,
    }